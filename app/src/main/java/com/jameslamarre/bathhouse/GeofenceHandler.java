package com.jameslamarre.bathhouse;

import android.content.Context;

import com.kl.kitlocate.class_interface.KLGeofence;
import com.kl.kitlocate.class_interface.KLLocalNotification;
import com.kl.kitlocate.utilities.interfaces.IKLGeofenceResponse;

import java.util.ArrayList;

public class GeofenceHandler implements IKLGeofenceResponse {

    @Override
    public void geofenceInArm(final Context context, ArrayList<KLGeofence> klGeofences) {

    }

    @Override
    public void geofenceOutArm(final Context context, ArrayList<KLGeofence> klGeofences) {

    }

    @Override
    public void geofenceIn(final Context context, ArrayList<KLGeofence> klGeofences) {
        new KLLocalNotification(context, getMessageFromArrayOfGeofences(klGeofences), R.drawable.point).setDefaultSound(true).setNotificationID(101).setContentTitle("GEOFENCE IN").send();
    }

    @Override
    public void geofenceOut(final Context context, ArrayList<KLGeofence> klGeofences) {
        new KLLocalNotification(context, getMessageFromArrayOfGeofences(klGeofences), R.drawable.point).setDefaultSound(true).setNotificationID(102).setContentTitle("GEOFENCE OUT").send();
    }

    private static String getMessageFromArrayOfGeofences(ArrayList<KLGeofence> alGeofences)
    {
        String strMessage = "";
        if(alGeofences != null && alGeofences.size() > 0)
        {
            strMessage += "{"+String.valueOf(alGeofences.size())+"}";
            for(Object obj : alGeofences)
            {
                KLGeofence geo = (KLGeofence) obj;
                strMessage += "(";
                boolean bSaw = false;
                if(!geo.getIDServer().equalsIgnoreCase(""))
                {
                    strMessage +=  "S[" + geo.getIDServer() + "]";
                    bSaw = true;
                }
                if(!geo.getIDUser().equalsIgnoreCase(""))
                {
                    strMessage += "U["+geo.getIDUser() + "]";
                    bSaw = true;
                }
                if(!bSaw)
                {
                    strMessage += "I[" + String.valueOf(geo.getIDPrimary()) + "]";
                }
                strMessage += ")";
            }
        } else {
            strMessage += " Problem";
        }
        return strMessage;
    }
}
