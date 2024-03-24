public static void main(String[] args) {

    Directory dir1 = new Directory("d1");
    File file1 = new File("f1");
    Directory dir2 = new Directory("d2");
    File file2 = new File("f2");

    dir2.add(file2);
    dir1.add(file1);
    dir1.add(dir2);

    dir1.ls();



}