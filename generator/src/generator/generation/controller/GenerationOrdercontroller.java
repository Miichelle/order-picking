package generator.generation.controller;

/**
 * Michelle Beckers
 * Datum: 9-8-2016
 * Time: 02:19
 */
public class GenerationOrdercontroller {
    private int nextId;

    public GenerationOrdercontroller(int startingId) {
        this.nextId = startingId;
    }

    public int getNextId() { return this.nextId; }
}
