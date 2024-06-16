package it.mjicio.plugin.utils;


public enum Roles {

        BOSS(4),
        VICEBOSS(3),
        ANZIANO(2),
        SCHIAVO(1);

        private final int value;

        Roles(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }


