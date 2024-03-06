package com.ahmet.learnedmovementrobot.learnedMovement;

/**
 * Author: Ahmet TOPAK
 * Since: 3/6/2024
 */
public class Position {
    private String name;
    private float turretAngle;
    private float shoulderAngle;
    private float elbowAngle;
    private float wristAngle;
    private float clampAngle;
    private float clampTurretAngle;
    private float frontPalAngle;
    private float backPalAngle;

    public Position(String name, float turretAngle, float shoulderAngle, float elbowAngle, float wristAngle,
                    float clampAngle, float clampTurretAngle, float frontPalAngle, float backPalAngle) {
        this.name = name;
        this.turretAngle = turretAngle;
        this.shoulderAngle = shoulderAngle;
        this.elbowAngle = elbowAngle;
        this.wristAngle = wristAngle;
        this.clampAngle = clampAngle;
        this.clampTurretAngle = clampTurretAngle;
        this.frontPalAngle = frontPalAngle;
        this.backPalAngle = backPalAngle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTurretAngle() {
        return turretAngle;
    }

    public void setTurretAngle(float turretAngle) {
        this.turretAngle = turretAngle;
    }

    public float getShoulderAngle() {
        return shoulderAngle;
    }

    public void setShoulderAngle(float shoulderAngle) {
        this.shoulderAngle = shoulderAngle;
    }

    public float getElbowAngle() {
        return elbowAngle;
    }

    public void setElbowAngle(float elbowAngle) {
        this.elbowAngle = elbowAngle;
    }

    public float getWristAngle() {
        return wristAngle;
    }

    public void setWristAngle(float wristAngle) {
        this.wristAngle = wristAngle;
    }

    public float getClampAngle() {
        return clampAngle;
    }

    public void setClampAngle(float clampAngle) {
        this.clampAngle = clampAngle;
    }

    public float getClampTurretAngle() {
        return clampTurretAngle;
    }

    public void setClampTurretAngle(float clampTurretAngle) {
        this.clampTurretAngle = clampTurretAngle;
    }

    public float getFrontPalAngle() {
        return frontPalAngle;
    }

    public void setFrontPalAngle(float frontPalAngle) {
        this.frontPalAngle = frontPalAngle;
    }

    public float getBackPalAngle() {
        return backPalAngle;
    }

    public void setBackPalAngle(float backPalAngle) {
        this.backPalAngle = backPalAngle;
    }

    // Builder iç sınıfı
    public static class Builder {
        private String name; // ID alanı eklendi
        private float turretAngle;
        private float shoulderAngle;
        private float elbowAngle;
        private float wristAngle;
        private float clampAngle;
        private float clampTurretAngle;
        private float frontPalAngle;
        private float backPalAngle;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder turretAngle(float turretAngle) {
            this.turretAngle = turretAngle;
            return this;
        }

        public Builder shoulderAngle(float shoulderAngle) {
            this.shoulderAngle = shoulderAngle;
            return this;
        }

        public Builder elbowAngle(float elbowAngle) {
            this.elbowAngle = elbowAngle;
            return this;
        }

        public Builder wristAngle(float wristAngle) {
            this.wristAngle = wristAngle;
            return this;
        }

        public Builder clampAngle(float clampAngle) {
            this.clampAngle = clampAngle;
            return this;
        }

        public Builder clampTurretAngle(float clampTurretAngle) {
            this.clampTurretAngle = clampTurretAngle;
            return this;
        }

        public Builder frontPalAngle(float frontPalAngle) {
            this.frontPalAngle = frontPalAngle;
            return this;
        }

        public Builder backPalAngle(float backPalAngle) {
            this.backPalAngle = backPalAngle;
            return this;
        }

        public Position build() {
            return new Position(name, turretAngle, shoulderAngle, elbowAngle, wristAngle,
                    clampAngle, clampTurretAngle, frontPalAngle, backPalAngle);
        }
    }
}
