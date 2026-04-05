class TV {
    public void on() {
        System.out.println("TV включен");
    }

    public void off() {
        System.out.println("TV выключен");
    }

    public void setChannel(String channel) {
        System.out.println("TV переключен на канал: " + channel);
    }

    public void setInput(String input) {
        System.out.println("TV вход установлен на: " + input);
    }
}

class AudioSystem {
    public void on() {
        System.out.println("Аудиосистема включена");
    }

    public void off() {
        System.out.println("Аудиосистема выключена");
    }

    public void setVolume(int level) {
        System.out.println("Громкость установлена на: " + level);
    }
}

class DVDPlayer {
    public void play() {
        System.out.println("DVD воспроизводится");
    }

    public void pause() {
        System.out.println("DVD на паузе");
    }

    public void stop() {
        System.out.println("DVD остановлен");
    }
}

class GameConsole {
    public void on() {
        System.out.println("Игровая консоль включена");
    }

    public void startGame(String game) {
        System.out.println("Запуск игры: " + game);
    }
}

class HomeTheaterFacade {
    private TV tv;
    private AudioSystem audio;
    private DVDPlayer dvd;
    private GameConsole console;

    public HomeTheaterFacade(TV tv, AudioSystem audio, DVDPlayer dvd, GameConsole console) {
        this.tv = tv;
        this.audio = audio;
        this.dvd = dvd;
        this.console = console;
    }

    public void watchMovie() {
        System.out.println("\n=== Режим: Просмотр фильма ===");
        tv.on();
        tv.setInput("DVD");
        audio.on();
        audio.setVolume(20);
        dvd.play();
    }

    public void listenMusic() {
        System.out.println("\n=== Режим: Прослушивание музыки ===");
        tv.on();
        tv.setInput("AUDIO");
        audio.on();
        audio.setVolume(15);
    }

    public void playGame(String game) {
        System.out.println("\n=== Режим: Игра ===");
        tv.on();
        tv.setInput("GAME");
        console.on();
        console.startGame(game);
    }

    public void setVolume(int level) {
        audio.setVolume(level);
    }

    public void turnOff() {
        System.out.println("\n=== Выключение системы ===");
        dvd.stop();
        audio.off();
        tv.off();
    }
}

public class MainFacade {
    public static void main(String[] args) {
        TV tv = new TV();
        AudioSystem audio = new AudioSystem();
        DVDPlayer dvd = new DVDPlayer();
        GameConsole console = new GameConsole();

        HomeTheaterFacade home = new HomeTheaterFacade(tv, audio, dvd, console);

        home.watchMovie();
        home.listenMusic();
        home.playGame("FIFA 25");
        home.setVolume(10);
        home.turnOff();
    }
}
