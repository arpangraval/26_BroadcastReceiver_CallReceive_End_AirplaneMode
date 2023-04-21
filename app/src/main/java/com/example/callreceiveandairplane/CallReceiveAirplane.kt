package com.example.callreceiveandairplane

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.view.Gravity
import android.widget.Toast

class CallReceiveAirplane: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
         val isAirplaneEnabled = intent!!.getBooleanExtra("state", false)
        if (intent!!.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_RINGING) {
            showToast(context, "Incoming Call...")
        } else if (intent!!.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_OFFHOOK) {
            showToast(context, "Call Received...")
        }
        else if (intent!!.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_IDLE) {
            showToast(context, "Call Ended...")
        }
        else if(isAirplaneEnabled ==  true){
            showToast(context, "Airplane Mode is Enabled...")
        }
        else if(isAirplaneEnabled ==  false){
            showToast(context, "Airplane Mode is Disabled...")
        }
    }
    fun showToast(context: Context?, msg:String){
        var toast = Toast.makeText(context,msg, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0,0)
        toast.show()
    }
}