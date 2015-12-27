package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

//import static com.qualcomm.ftcrobotcontroller.opmodes.Gyro.gyroTurn;

/**
 * Created by heel7_000 on 12/4/2015.
 */
public class Autonomous extends Gyro {
    Servo one;
    Servo two;



    @Override
    public void init() {
        one = hardwareMap.servo.get("arm");
        two = hardwareMap.servo.get("leftS");
        gyroSensor = hardwareMap.gyroSensor.get("gyro");
        gyroSensor.calibrate();
        if (gyroSensor.isCalibrating()) {
            sleep(400);
        }

        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
    }

    @Override
    public void loop() {
       telemetry.addData("Gyro Value", gyroSensor.getHeading());
       Gyro myGyro = new Gyro();
        //myGyro.moveCentimetersTyre(200, 9.75,.3);

     //   sleep(500);
        myGyro.moveCentimetresTyre(100, 9.74,.3);
        sleep(500);
        myGyro.gyroTurn(90,0.075);
        
    }

    @Override
    public void stop() {
        super.stop();
    }
}
