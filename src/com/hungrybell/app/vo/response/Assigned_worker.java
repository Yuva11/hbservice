package com.hungrybell.app.vo.response;

public class Assigned_worker {

    private String phone_number;

    private Location location;

    private String name;

    private String assigned_worker_id;

    public String getPhone_number ()
    {
        return phone_number;
    }

    public void setPhone_number (String phone_number)
    {
        this.phone_number = phone_number;
    }

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getAssigned_worker_id ()
    {
        return assigned_worker_id;
    }

    public void setAssigned_worker_id (String assigned_worker_id)
    {
        this.assigned_worker_id = assigned_worker_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [phone_number = "+phone_number+", location = "+location+", name = "+name+", assigned_worker_id = "+assigned_worker_id+"]";
    }
}
