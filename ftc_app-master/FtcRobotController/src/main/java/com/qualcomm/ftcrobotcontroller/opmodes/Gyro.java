package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

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
                A.setPower(c+(2*(b-temp)));
                B.setPower(c-(2*(b-temp)));
            }
            if(a.getHeading()>b && a.getHeading()>1){
                int temp = a.getHeading();
                A.setPower(c-(2*(temp-b)));
                B.setPower(c+(2*(temp-b)));
            }
            if ((a.getHeading())<((b+360))){
                int temp = a.getHeading();
                A.setPower(c+(2*(b-temp)));
                B.setPower(c-(2*(b-temp)));

            }
            if(a.getHeading()+360>b){
                int temp = a.getHeading();
                A.setPower(c-(2*(temp-b)));
                B.setPower(c+(2*(temp-b)));
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
