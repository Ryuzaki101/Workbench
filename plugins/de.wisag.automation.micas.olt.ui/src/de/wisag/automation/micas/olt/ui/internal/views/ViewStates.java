package de.wisag.automation.micas.olt.ui.internal.views;

public interface ViewStates {
    public interface IPositionFSM {
        default IPositionFSM processFoo() {
            return this;
        }

        default IPositionFSM processBar() {
            return this;
        }
    }

    public enum PositionFSM implements IPositionFSM {
        State1 {
            @Override
            public IPositionFSM processFoo() {
                return State2;
            }
        },
        State2 {
            @Override
            public IPositionFSM processBar() {
                return State1;
            }
        };
    }
}
