package org.DrsG.Genome.BeBl;

public class D_BeBl_User {
    private enum userRoles {NONE, TEAMLEAD, TECHNICALSUPPORT, BIOINFORMATICIAN}
    userRoles role = userRoles.NONE;
    private String firstName = "INVALID_USER";
    private String lastName = "INVALID_USER";

    public D_BeBl_User()
    {
    }

    public D_BeBl_User(String aFirstName, String aLastName, String aRole)
    {
        this.setFirstName(aFirstName);
        this.setLastName(aLastName);
        this.setRole(aRole);
    }

    public void setFirstName(String aFirstName)
    {
        this.firstName = aFirstName;
    }

    public void setLastName(String aLastName)
    {
        this.lastName = aLastName;
    }

    public void setRole (String aRole)
    {
        String theRole = aRole.toLowerCase();
        if (theRole.equals("teamlead"))
        {
            this.role = userRoles.TEAMLEAD;
        } else if (theRole.equals("technicalsupport"))
            {
                this.role = userRoles.TECHNICALSUPPORT;
            } else if (theRole.equals("bioinformatician"))
                {
                    this.role = userRoles.BIOINFORMATICIAN;
                }
                else
                    {
                        System.out.println("invalid role - check spelling of the assigned role (teamlead, technicalsupport, bioinformatician)");
                    }

    }



    public String getFirstName()
    {
        return this.firstName;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public String getRole() {return String.valueOf(this.role);}

    public String getOverview ()
    {
        String overview = "";
        overview = "Firstname = " + this.getFirstName() + " ; LastName = " + this.getLastName() + " ; Role = " +String.valueOf(this.role) + "\n";
        return overview;
    }
}
