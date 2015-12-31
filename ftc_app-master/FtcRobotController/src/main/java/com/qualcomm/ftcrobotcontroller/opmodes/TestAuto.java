package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by heel7 on 12/28/2015.
 */
public class TestAuto extends Gyro {

    Servo servoOne;
    Servo servoTwo;

    private int state = 0;

    static int MARGIN = 3;

    @Override
    public void init() {
        servoOne = hardwareMap.servo.get("arm");
        servoTwo = hardwareMap.servo.get("leftS");
        gyroSensor = hardwareMap.gyroSensor.get("gyro");
        gyroSensor.calibrate();
        if (gyroSensor.isCalibrating()) {
            sleep(400);
        }
        leftMotor = hardwareMap.dcMotor.get("left");
        rightMotor = hardwareMap.dcMotor.get("right");
        telemetry.addData("Yo init", state);
    }

    @Override
    public void start() {
        super.start();

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);

    }

    @Override
    public void loop() {

        switch (state) {
            case 0:
                leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
                rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
                state++;
                break;
            case 1:
                leftMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
                rightMotor.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

                double count = calculateEncoderCountFromDistance(100);

//                rightMotor.setTargetPosition((int) (count));
//                leftMotor.setTargetPosition((int) (count));
//                rightMotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
//                leftMotor.setMode(DcMotorController.RunMode.RUN_TO_POSITION);

                setDrivePower(0.3, 0.3);

                //
                // Have the motor shafts turned the required amount?
                //
                // If they haven't, then the op-mode remains in this state (i.e this
                // block will be executed the next time this method is called).
                //
                if (haveEncodersReached(count, count)) {
                    leftMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);
                    rightMotor.setMode(DcMotorController.RunMode.RESET_ENCODERS);

                    //
                    // Stop the motors.
                    //
                    setDrivePower(0.0f, 0.0f);

                    //
                    // Transition to the next state when this method is called
                    // again.
                    //
                    state++;
                }
                break;

            case 2:
                if (haveDriverEncodersReset()) {
                    state++;
                }
                break;
            case 3:
                // turn
                leftMotor.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
                rightMotor.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
                setDrivePower(-0.075f, +0.075f);
                if (hasGyroReachedValue(90, MARGIN)) {
                    setDrivePower(0.0, 0.0);
                    state++;
                }
                break;
            default:
                break;
        }

    }
}
