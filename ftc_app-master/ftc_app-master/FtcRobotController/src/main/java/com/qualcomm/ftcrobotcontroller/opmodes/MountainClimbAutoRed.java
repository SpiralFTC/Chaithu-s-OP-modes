package com.qualcomm.ftcrobotcontroller.opmodes;

public class MountainClimbAutoRed extends LinearMethods {
    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();

        while (opModeIsActive()) {
            lightSensor.enableLed(true);
            telemetry.addData("Light Value: ", lightSensor.getLightDetected());

            if (lightSensor.getLightDetected() > 0.2) {
                driveForward(0.2);
                repositionStep = 1;
            } else {
                switch (repositionStep) {
                    case 1:
                        if (driveForwardForTime(0, 100)) {
                            repositionStep++;
                        }
                        break;
                    case 2:
                        if (driveBackwardForTime(0.25, 300)) {
                            repositionStep++;
                        }
                        break;

                    case 3:
                        if (turnRightForTime(0.2, 840)) {
                            repositionStep++;
                        }
                        break;

                    case 4:
                        if (driveForwardForTime(0.5, 1500)) {
                            repositionStep++;
                        }
                        break;
                    default:
                        repositionStep = 1;
                        break;
                }
            }


            waitOneFullHardwareCycle();

        }


    }



        }



