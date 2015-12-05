package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by heel7_000 on 12/3/2015.
 */
public class Gyro extends Gyro_Programs {
    //GyroSensor aa;
    //int b;
    DcMotor A;

    public void gyroTurn(GyroSensor a, int b){
        int t = 0;
        while (t == 1){
            if (a.getHeading() == b){
                A.setPower(0);
                B.setPower(0);
                t=1;
                A.setPower(0);
                B.setPower(0);
            }
            else if (b<=180){
                A.setPower(.5);
                B.setPower(-.5);
            }
            else {
                A.setPower(-.5);
                B.setPower(.5);
            }
        }

    }
    public static void sleep(long sleepTime)
    {
        long wakeupTime = System.currentTimeMillis() + sleepTime;

        while (sleepTime > 0)
        {
            try
            {
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException e)
            {
                sleepTime = wakeupTime - System.currentTimeMillis();
            }
        }
    }
    //sleep
    public static void sleepMove(long sleepTime,GyroSensor a,int b,double c,DcMotor A, DcMotor B )
    {
        long wakeupTime = System.currentTimeMillis() + sleepTime;

        while (sleepTime > 0)
        {
            if (a.getHeading()<b && a.getHeading()<180){
                int temp = a.getHeading();
                double C =(c+(2*(b-temp)));
                double D = (c-(2*(b-temp)));
                Range.clip(C,-1,1);
                Range.clip(D,-1,1);
                A.setPower(C);
                B.setPower(D);
            }
            if(a.getHeading()>b && a.getHeading()>1){
                int temp = a.getHeading();
                double C = (c-(2*(temp-b)));
                double D = (c+(2*(temp-b)));
                Range.clip(C,-1,1);
                Range.clip(D,-1,1);
                A.setPower(C);
                B.setPower(D);
            }
            if ((a.getHeading())<((b+360))){
                int temp = a.getHeading();
                double C =(c+(2*(b-temp)));
                double D = (c-(2*(b-temp)));
                Range.clip(C,-1,1);
                Range.clip(D,-1,1);
                A.setPower(C);
                B.setPower(D);
            }
            if(a.getHeading()+360>b){
                int temp = a.getHeading();
                double C = (c-(2*(temp-b)));
                double D = (c+(2*(temp-b)));
                Range.clip(C,-1,1);
                Range.clip(D,-1,1);
                A.setPower(C);
                B.setPower(D);
            }

            try
            {
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException e)
            {
                sleepTime = wakeupTime - System.currentTimeMillis();
            }
        }
    }   //sleep
    
}
