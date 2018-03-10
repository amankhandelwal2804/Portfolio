package com.when.threemb.portfolio;

/**
 * Created by User on 3/24/2017.
 */

public class Qualification {
    String course,institute,board,year;

    public Qualification(String board, String course, String institute, String year) {
        this.board = board;
        this.course = course;
        this.institute = institute;
        this.year = year;
    }

    public String getBoard() {
        return board;
    }

    public String getCourse() {
        return course;
    }

    public String getInstitute() {
        return institute;
    }

    public String getYear() {
        return year;
    }
}
