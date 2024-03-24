public Directory implement FileSystem
{
    String dirname;
    List<FileSystem> listoffile

    public Directory(String dirname)
    {
        this.dirname = dirname;
        listoffile = new ArrayList<>();
    }

    public void add(FileSystem fobj)
    {
        listoffile.add(fobj);
    }

    public void ls()
    {
        system.println("directoryname", dirname);
        for(FileSystem flobj : listoffile){
            flobj.ls();
        }
    }

}