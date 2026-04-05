import java.util.ArrayList;
import java.util.List;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void display(int depth);
    public abstract int getSize();
}

class File extends FileSystemComponent {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void display(int depth) {
        System.out.println("  ".repeat(depth) + "- Файл: " + name + " (" + size + " KB)");
    }

    @Override
    public int getSize() {
        return size;
    }
}

class Directory extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void add(FileSystemComponent component) {
        if (!children.contains(component)) {
            children.add(component);
        } else {
            System.out.println("Компонент уже существует: " + component.name);
        }
    }

    public void remove(FileSystemComponent component) {
        if (children.contains(component)) {
            children.remove(component);
        } else {
            System.out.println("Компонент не найден: " + component.name);
        }
    }

    @Override
    public void display(int depth) {
        System.out.println("  ".repeat(depth) + "+ Папка: " + name);
        for (FileSystemComponent component : children) {
            component.display(depth + 1);
        }
    }

    @Override
    public int getSize() {
        int total = 0;
        for (FileSystemComponent component : children) {
            total += component.getSize();
        }
        return total;
    }
}

public class MainComposite {
    public static void main(String[] args) {

        Directory root = new Directory("Корень");

        Directory docs = new Directory("Документы");
        Directory images = new Directory("Изображения");

        File file1 = new File("resume.pdf", 120);
        File file2 = new File("photo.jpg", 300);
        File file3 = new File("notes.txt", 50);

        docs.add(file1);
        docs.add(file3);

        images.add(file2);

        root.add(docs);
        root.add(images);

        root.add(images);

        System.out.println("\n=== Структура файлов ===");
        root.display(0);

        System.out.println("\nОбщий размер: " + root.getSize() + " KB");

        docs.remove(file3);

        System.out.println("\n=== После удаления ===");
        root.display(0);
    }
}
