package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
    private Viewport viewport;
	private Stage stage;
	private Skin skin;
	private Label label[];
	private Table scrollTable;
	private Table table;
	private ScrollPane scroller;
	private String longString = "Look, I was gonna";// go easy on you and not tell you to give up or do something ";

    @Override
    public void create() {
    //   viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());//
       stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);
        skin = new Skin(Gdx.files.internal("biological-attack-ui.json"));

      Pixmap pixmap = new Pixmap(1,1,Pixmap.Format.RGB565);
        pixmap.setColor(Color.BLUE);
       pixmap.fill();
       TextureRegionDrawable textureRegionDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));

        Pixmap pixmap2 = new Pixmap(1,1,Pixmap.Format.RGB565);
        pixmap2.setColor(Color.RED);
        pixmap2.fill();
        TextureRegionDrawable textureRegionDrawable2 = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap2)));

        scrollTable = new Table();

        label = new Label[105];
        label[0] = new Label("", skin);
        label[0].setAlignment(Align.bottomRight);
        scrollTable.add(label[0]);
        scrollTable.row();
        for (int i = 1; i < 101; i++) {

            label[i] = new Label(longString + i, skin);
            label[i].setAlignment(Align.bottomRight);
            scrollTable.add(label[i]);
            scrollTable.row();
        //    label[i].setAlignment(Align.center);
        }
        for (int i = 101; i < 105; i++) {

            label[i] = new Label("", skin);
            label[i].setAlignment(Align.bottomRight);
            scrollTable.add(label[i]);
            scrollTable.row();
            //    label[i].setAlignment(Align.center);
        }
scrollTable.right().bottom();
  //     scrollTable.setBackground(textureRegionDrawable2);
        scroller = new ScrollPane(scrollTable);

        table = new Table();
      //  table.setPosition(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),Align.bottomLeft);
        table.setFillParent(true);
//        table.setBackground(textureRegionDrawable);
        table.add(scroller).grow();
 //       table.setPosition(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
 //      table.setWidth(Gdx.graphics.getHeight()/100);
        table.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        stage.setDebugAll(true);

        stage.addActor(table);
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
       stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
