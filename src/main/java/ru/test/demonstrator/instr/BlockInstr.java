package ru.test.demonstrator.instr;

public class BlockInstr {
    String instrStr;

    public BlockInstr(String instr) {
        this.instrStr = instr;
    }

    @Override
    public String toString() {
        return instrStr;
    }
}
