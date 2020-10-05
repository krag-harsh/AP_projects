public class commoner extends player {
    public void commoner()
    {
        setUniqueID(getCountofunid());
        setCountofunid(getCountofunid()+1);
        setIsalive(true);
        setHP(1000);
        setVoted(0);
    }


}
