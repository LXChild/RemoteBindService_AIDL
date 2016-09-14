package com.example.lxchild.remotebindservice_aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.lxchild.aidl.IMyAidlInterface;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myS;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    private IBinder myS = new IMyAidlInterface.Stub() {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int sum(int a, int b) throws RemoteException {
            Log.i("Hensen", "从客户端发来的AIDL请求:num1->" + a + "::num2->" + b);
            return MyService.this.sum(a, b);
        }
    };
}
