package main.java.action;

import main.java.action.entity.Entity;

import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Field {
    private final int height;
    private final int width;
    private final Map<Coordinates, Entity> field;

    public Field(int rows, int columns) {
        this.height = rows;
        this.width = columns;
        this.field = new HashMap<>(rows * columns);
    }

    public void setEntity(Entity entity, Coordinates coordinates) {
        if (isValidCoordinates(coordinates)) {
            field.put(coordinates, entity);
        } else {
            throw new IllegalArgumentException("Coordinates is not available");
        }
    }

    public Entity getEntity(Coordinates coordinates) {
        if (containsEntity(coordinates)) {
            return field.get(coordinates);
        }
        throw new NoSuchElementException("Field doesn't contain entity on these coordinates");
    }

    public void removeEntity(Coordinates coordinates) {
        if (containsEntity(coordinates)) {
            field.remove(coordinates);
        }
        throw new NoSuchElementException("Field doesn't contain entity on these coordinates");
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean containsEntity(Coordinates coordinates) {
        return !(field.get(coordinates) == null);
    }

    public boolean isValidCoordinates(Coordinates coordinates) {
        if (coordinates.getRow() < 0 || coordinates.getRow() >= getHeight()) {
            return false;
        }
        if (coordinates.getColumn() < 0 || coordinates.getColumn() >= getWidth()) {
            return false;
        }
        return true;
    }

    public boolean isEmptySquare(Coordinates coordinates) {
        return !containsEntity(coordinates);
    }
}
