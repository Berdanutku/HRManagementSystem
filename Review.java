class Review { // Performance Review Class for holding specific attributes of a performance review
    private int QofW; // Quality of Work
    private int AandP; // Attendance & Punctuality
    private int Comm; // Communication Skills
    private int JandDM; // Judgement & Decision Making
    private int Coop; // Cooperation & Teamwork
    private int Average;

    public Review(int qofW, int aandP, int comm, int jandDM, int coop,int average) {
        QofW = qofW;
        AandP = aandP;
        Comm = comm;
        JandDM = jandDM;
        Coop = coop;
        Average=average;
    }

    public String getQofW() { // get method for Quality of Work
        switch (QofW) { // converts integer values to string equivalent
            case 1:
                return "Unacceptable";
            case 2:
                return "Needs development";
            case 3:
                return "Meets expectations";
            case 4:
                return "Exceeds expectations";
            default:
                return "(Evaluation Needed)";
        }
    }

    public String getAandP() {  // get method for Attendance & Punctuality
        switch (AandP) { // converts integer values to string equivalent
            case 1:
                return "Unacceptable";
            case 2:
                return "Needs development";
            case 3:
                return "Meets expectations";
            case 4:
                return "Exceeds expectations";
            default:
                return "(Evaluation Needed)";
        }
    }

    public String getComm() { // get method for Communication Skills
        switch (Comm) { // converts integer values to string equivalent
            case 1:
                return "Unacceptable";
            case 2:
                return "Needs development";
            case 3:
                return "Meets expectations";
            case 4:
                return "Exceeds expectations";
            default:
                return "(Evaluation Needed)";
        }
    }

    public String getJandDM() { // get method for Judgement & Decision Making
        switch (JandDM) { // converts integer values to string equivalent
            case 1:
                return "Unacceptable";
            case 2:
                return "Needs development";
            case 3:
                return "Meets expectations";
            case 4:
                return "Exceeds expectations";
            default:
                return "(Evaluation Needed)";
        }
    }

    public String getCoop() { // get method for Cooperation & Teamwork
        switch (Coop) { // converts integer values to string equivalent
            case 1:
                return "Unacceptable";
            case 2:
                return "Needs development";
            case 3:
                return "Meets expectations";
            case 4:
                return "Exceeds expectations";
            default:
                return "(Evaluation Needed)";
        }
    }

    public int getAverage() {
        return Average;
    }
}
