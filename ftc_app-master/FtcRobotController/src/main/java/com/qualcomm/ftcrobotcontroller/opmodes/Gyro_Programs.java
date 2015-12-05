package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by heel7_000 on 12/3/2015.
 */
public class Gyro_Programs extends OpMode {
    DcMotor A;
    DcMotor B;
    @Override
    public void init() {

    }

    @Override
    public void start() {
       // super.start();
    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {
        //super.stop();
    }

    public void gyroStraight(GyroSensor a,int b,double c ){
        //GyroSensor aa;
        //aa.equals(a);
        //this.b = b;

        if (a.getHeading()<b && a.getHeading()<180){
            int temp = a.getHeading();
            double C =(c+(2*(b-temp)));
            double D = (c-(2*(b-temp)));
            Range.clip(C, -1, 1);
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
    }
}
