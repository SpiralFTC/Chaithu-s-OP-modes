package com.qualcomm.ftcrobotcontroller.opmodes;



/**
 * Created by SrinivasaRao on 11/1/2015.
 */
public class MountainClimb_AUTO_Red extends Linear_Methods {

    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        while (opModeIsActive()) {
            lightSensor.enableLed(true);
            telemetry.addData("Light Value: ", lightSensor.getLightDetected());

            Wait_10Sec(0);
            sleep(9999);


            if (lightSensor.getLightDetected() > 0.2) {

                DriveForward(0.2);

            } else {
                DriveForward(0);
                sleep(100);
                DriveBackward(0.25);
                sleep(300);

                TurnRight(0.2);
                sleep(840);

                DriveForward(.5);
                sleep(1500);
            }


           /* if (lightSensor.getLightDetected() < 0.6 && lightSensor.getLightDetected() > 0.3) {
                DriveBackward(0.5);
                sleep(500);

                TurnLeft(0.1);
                sleep(50);

                DriveForward(1);


            } else {
                TurnRight(0.3);
                sleep(200);

                DriveForward(.5);
                }
           */
            waitOneFullHardwareCycle();

        }


    }

}