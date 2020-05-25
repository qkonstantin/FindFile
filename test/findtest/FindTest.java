package findtest;

import find.Find;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.ArrayList;

import static java.io.File.separatorChar;

public class FindTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private ArrayList<String> list = new ArrayList<String>();

    @Test
    public void test1() { //Поиск файла в директории с флагом r
        File directory = new File("directory");
        File fileName = new File(directory, "one.txt");
        Find file = new Find(true, directory, fileName);
        list.add(new File("").getAbsolutePath()+separatorChar+fileName);
        Assert.assertEquals(list, file.getFilePath());
    }

    @Test
    public void test2() { //Поиск файла в поддиректории с флагом r
        File directory = new File("directory");
        File fileName = new File( "two.txt");
        Find file = new Find(true, directory, fileName);
        list.add(new File("").getAbsolutePath()+separatorChar+directory+separatorChar+"1"+separatorChar+fileName);
        Assert.assertEquals(list, file.getFilePath());
    }

    @Test
    public void test3() { //Поиск папки в директории с флагом r
        File directory = new File("directory");
        File fileName = new File(directory, "1");
        Find file = new Find(true, directory, fileName);
        list.add(new File("").getAbsolutePath()+separatorChar+fileName);
        Assert.assertEquals(list, file.getFilePath());
    }

    @Test
    public void test4() { //Поиск папки в поддиректории с флагом r
        File directory = new File("directory");
        File fileName = new File( "2");
        Find file = new Find(true, directory, fileName);
        list.add(new File("").getAbsolutePath()+separatorChar+directory+separatorChar+"1"+separatorChar+fileName);
        Assert.assertEquals(list, file.getFilePath());
    }

    @Test
    public void test5() { //Поиск файла в директории без флага r
        File directory = new File("directory");
        File fileName = new File(directory, "one.txt");
        Find file = new Find(false, directory, fileName);
        list.add(new File("").getAbsolutePath()+separatorChar+fileName);
        Assert.assertEquals(list, file.getFilePath());
    }

    @Test
    public void test6() { //Поиск файла в поддиректории без флага r (несуществующего файла)
        File directory = new File("directory");
        File fileName = new File( "two.txt");
        Find file = new Find(false, directory, fileName);
        Assert.assertEquals(list, file.getFilePath());
    }

    @Test
    public void test7() { //Поиск папки в директории без флага r
        File directory = new File("directory");
        File fileName = new File(directory, "1");
        Find file = new Find(false, directory, fileName);
        list.add(new File("").getAbsolutePath()+separatorChar+fileName);
        Assert.assertEquals(list, file.getFilePath());
    }

    @Test
    public void test8() { //Поиск папки в поддиректории без флага r (несуществующей папки)
        File directory = new File("directory");
        File fileName = new File( "2");
        Find file = new Find(false, directory, fileName);
        Assert.assertEquals(list, file.getFilePath());
    }

    @Test
    public void test9() { //Несуществующая директория
        thrown.expect(IllegalArgumentException.class);
        File directory = new File("nonexistent_directory");
        File fileName = new File( "2");
        Find file = new Find(false, directory, fileName);
    }

    @Test
    public void test10() { //Несуществующая директория
        thrown.expect(IllegalArgumentException.class);
        File directory = new File("nonexistent_directory");
        File fileName = new File( "3");
        Find file = new Find(true, directory, fileName);
    }
}
