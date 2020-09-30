package ru.skillbench.tasks.basics.math;

import java.lang.management.BufferPoolMXBean;
import java.util.Arrays;
import java.util.Objects;

public class ComplexNumberImpl implements ComplexNumber{
    private double re;
    private double im;

    public ComplexNumberImpl() {
        re = 0;
        im = 0;
    }

    public ComplexNumberImpl(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {
        return im == 0;
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        //TODO: см. parceDouble, нужно распарсить числа. Перевернуть строку, посмотреть наличие i. Если i нету, тогда просто число.
        // Если i есть, тогда парсим число до знака в перевёрнутом виде(?), затем сам знак. Оставшуюся часть парсим на число.

        if (value.charAt(value.length() - 1) == 'i') {
            StringBuffer buffer = new StringBuffer();
            int i = value.length() - 2;
            while ((value.charAt(i) != '+' || value.charAt(i) != '-') && i >= 0) {  //TODO: почему всегда true??
                if (value.charAt(i) - '0' >= 0 && value.charAt(i) - '0' <= 9 || value.charAt(i) == '.') {
                    buffer.append(value.charAt(i));
                    i--;
                } else {
                    throw new NumberFormatException("Inappropriate value"); //TODO: текст в скобках нужен?
                }
            }
            buffer.reverse();
            System.out.println(buffer);

            StringBuffer buffer1 = new StringBuffer();
            for (int j = 0; j <= i; j++) {
                buffer1.append(value.charAt(j));
            }
            System.out.println("Parced re_im: " + buffer1 + " " + buffer);

            if (buffer1.toString().isEmpty()) {
                this.re = 0;
            } else {
                this.re = Double.parseDouble(buffer1.toString());
            }

            if (buffer.toString().isEmpty()) {
                this.im = 0;
            } else {
                this.im = Double.parseDouble(buffer.toString());
            }

        } else {
            this.re = Double.parseDouble(value);
        }
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumber complexNumber = new ComplexNumberImpl();
        complexNumber.set(this.re, this.im);
        //TODO: если не прокатит, то нужно переписать clone() и вставить сюда
        System.out.println(complexNumber.getRe() + " " + complexNumber.getIm());
        return complexNumber;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return (ComplexNumber) super.clone();
    }

    @Override
    public String toString() {
        if (re != 0 && im == 0) {
            return Double.toString(re);
        }
        if (re == 0 && im != 0) {
            return Double.toString(im) + "i";
        }
        return Double.toString(re) + Double.toString(im) + "i";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        ComplexNumber that = (ComplexNumber) other;
        return this.re == that.getRe() && this.im == that.getIm();
    }

    @Override
    public int compareTo(ComplexNumber other) {
        return (int) Math.signum(Math.pow(re, 2) + Math.pow(im, 2) - Math.pow(other.getRe(), 2) + Math.pow(other.getIm(), 2));
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array, ComplexNumber::compareTo); //TODO: найти вариант с компаратором
    }

    @Override
    public ComplexNumber negate() {
        re *= -1;
        im *= -1;
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        re += arg2.getRe();
        im += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double nRe = re * arg2.getRe() - im * arg2.getIm();
        double nIm = im * arg2.getRe() + re * arg2.getIm();
        re = nRe; im = nIm;
        return this;
    }
}
