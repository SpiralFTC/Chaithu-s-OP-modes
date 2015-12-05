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
    DcMotor B;
    public void gyroStraight(GyroSensor a,int b,int c ){
        //GyroSensor aa;
        //aa.equals(a);
        //this.b = b;
        if (a.getHeading()<b){
           int temp = a.getHeading();
            A.setPower(c+(2*(b-temp)));
            B.setPower(c-(2*(b-temp)));
        }
        if(a.getHeading()>b){
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
    }
    public void gyroTurn(GyroSensor a, int b){
        int t = 0;
        while (t == 1){
            if (a.getHeading() == b){
                t=1;
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
}
