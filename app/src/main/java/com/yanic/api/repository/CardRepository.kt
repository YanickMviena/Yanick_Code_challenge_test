package com.yanic.api.repository

import android.content.Context
import androidx.activity.result.launch
import androidx.lifecycle.viewModelScope
import com.yanic.api.db.CardDao
import com.yanic.api.model.Card
import com.yanic.api.network.ApiService
import com.yanic.api.test.Util
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CardRepository @Inject constructor(private val apiService: ApiService,
                                         private val cardDao: CardDao,
                                         private val context: Context
) {

    fun fetchCards(scope: CoroutineScope): Flow<List<Card>> {
        return flow {
            if (Util.isNetworkAvailable(context)) {
                val cards = apiService.getCards().page.cards
                scope.launch(Dispatchers.IO) {
                    cardDao.insertAll(cards)
                }
                emit(cards)
            } else {
                emit(cardDao.getCards().first())
            }
        }
    }
}