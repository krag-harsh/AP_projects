public class commoner extends player {
    public commoner()
    {
        setUniqueID(getCountofunid());
        setCountofunid(getCountofunid()+1);
        setIsalive(true);
        setHP(1000);
        setVoted(0);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj!=null && getClass()==obj.getClass());
    }


}
