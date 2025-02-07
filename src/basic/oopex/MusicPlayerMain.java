package basic.oopex;

class MusicPlayer {
    private int volume = 0;
    private boolean isOn = false;

    void increaseVolume() {
        this.volume++;
        printVolume();
    }
    void decreaseVolume() {
        this.volume--;
        printVolume();
    }

    void printVolume() {
        System.out.println("음악 플레이어 볼륨: " + this.volume);
    }

    void turnOn() {
        this.isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");
    }

    void turnOff() {
        this.isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }

    void showStatus() {
        System.out.println("음악 플레이어 상태 확인");
        if (isOn) {
            System.out.println("음악 플레이어 ON, 볼륨: " + this.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }
}

public class MusicPlayerMain {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.turnOn();
        musicPlayer.increaseVolume();
        musicPlayer.increaseVolume();
        musicPlayer.decreaseVolume();
        musicPlayer.showStatus();
        musicPlayer.turnOff();
        musicPlayer.showStatus();
    }
}
