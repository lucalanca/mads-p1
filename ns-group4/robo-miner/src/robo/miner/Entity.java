package robo.miner;

public interface Entity {
    public int x = 0;
    public int y = 0;
    public abstract void update();
    @Override
    public String toString();
    //TODO ter acesso ao tabuleiro
}
