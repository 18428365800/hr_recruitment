package com.recruit.messages;

public class Position
{
    private int job_Id;
    private String job_name;
    private String job_description;

    public Position(int job_Id,String job_name,String job_description)
    {
        this.job_Id = job_Id;
        this.job_name = job_name;
        this.job_description = job_description;
    }

    public int getJob_Id()
    {
        return job_Id;
    }

    public String getJob_name()
    {
        return job_name;
    }

    public String getJob_description()
    {
        return job_description;
    }
}
