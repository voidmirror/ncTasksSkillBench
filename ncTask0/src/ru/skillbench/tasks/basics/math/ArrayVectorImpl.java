package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector{
    private double[] arr;

    public ArrayVectorImpl() {
        arr = new double[0]; //TODO: не надо нулл
    }

    public ArrayVectorImpl(double[] a) {
        set(a);
    }

    @Override
    public void set(double... elements) {
        arr = new double[elements.length];
        System.arraycopy(elements, 0, arr, 0, elements.length);
    }

    @Override
    public double[] get() { //TODO: это в clone()
//        double[] arrCopy = arr.clone();
        return arr;
    }

    @Override
    public ArrayVector clone() {
        return new ArrayVectorImpl(arr.clone());
    }

    @Override
    public int getSize() {
        return arr.length;
    }

    @Override
    public void set(int index, double value) {
        if (index >= arr.length) {
            double[] arrCopy = new double[index];
            Arrays.copyOf(arr, arrCopy.length);
            arr = arrCopy;
            arr[index] = value;
        } else if (index > 0) {
            arr[index] = value;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return arr[index];
    }

    @Override
    public double getMax() {
        double max;
        try {
            max = arr[0];
            for (double v : arr) {
                max = Math.max(max, v);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array has no elements");
            return 0;
        }

        return max;
    }

    @Override
    public double getMin() {
        double min;
        try {
            min = arr[0];
            for (double v : arr) {
                min = Math.min(min, v);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array has no elements");
            return 0;
        }

        return min;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(arr);
    }

    @Override
    public void mult(double factor) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        for (int i = 0; i < Math.min(arr.length, anotherVector.get().length); i++) {
            arr[i] += anotherVector.get()[i];
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double mult = 0;
        for (int i = 0; i < Math.min(arr.length, anotherVector.get().length); i++) {
            mult += arr[i]*anotherVector.get()[i];
        }
        return mult;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(scalarMult(this));
    }
}
