package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;


public class Autonomous extends Gyro {
    Servo RightServo;
    Servo LeftServo;


    double ServoPosition = 0.7;

    @Override
    public void init() {
        RightServo = hardwareMap.servo.get("arm");
        LeftServo = hardwareMap.servo.get("leftS");


        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        gyroSensor = hardwareMap.gyroSensor.get("gyro");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        gyroSensor.calibrate();
        if (gyroSensor.isCalibrating()) {
            sleep(100);
        }
    }

    @Override
    public void loop() {
        sleepMove(3000, 0, 1);

        //gyroTurn(89, 91);
        // sleepMove(3000, 75, .5);

        //leftMotor.setPower(0);
        //rightMotor.setPower(0);


        telemetry.addData("Gyro: ", gyroSensor.getHeading());
    }

    @Override
    public void stop() {
        // super.stop();
        System.out.println("Yo mama is fat");
    }

}
