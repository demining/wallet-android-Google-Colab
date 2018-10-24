package com.mycelium.wapi.wallet.manager

import com.mycelium.wapi.wallet.SyncMode
import com.mycelium.wapi.wallet.WalletAccount
import com.mycelium.wapi.wallet.WalletManager

class Synchronizer(val walletManager: WalletManager, val syncMode: SyncMode, val account: WalletAccount<*, *>? = null) : Runnable {

    override fun run() {
//        setStateAndNotify(State.SYNCHRONIZING)
        try {
            synchronized(walletManager.getAccounts()) {
                if (walletManager.isNetworkConnected) {
//                    if (!syncMode.ignoreMinerFeeFetch && (_lastFeeEstimations == null || _lastFeeEstimations.isExpired(MIN_AGE_FEE_ESTIMATION))) {
//                        // only fetch the fee estimations if the latest available fee is older than MIN_AGE_FEE_ESTIMATION
//                        fetchFeeEstimation()
//                    }

                    // If we have any lingering outgoing transactions broadcast them now
                    // this function goes over all accounts - it is reasonable to
                    // exclude this from SyncMode.onlyActiveAccount behaviour
//                    if (!broadcastOutgoingTransactions()) {
//                        return
//                    }

                    // Synchronize selected accounts with the blockchain
                    walletManager.getAccounts().forEach { it.synchronize(syncMode) }
                }

            }
        } finally {
//            setStateAndNotify(State.READY)
        }
    }
}