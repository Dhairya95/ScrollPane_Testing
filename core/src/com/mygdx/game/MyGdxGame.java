package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
    private Viewport viewport;
	private Stage stage;
	private Skin skin;
	private Label label[];
	private Table scrollTable;
	private Table table;
	private ScrollPane scroller;
	private String longString = "Look, I was gonna go easy on you and not to hurt your feelings";

    @Override
    public void create() {
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(this.stage);
        skin = new Skin(Gdx.files.internal("biological-attack-ui.json"));

        label = new Label[100];

        for (int i = 0; i < 100; i++) {
            label[i] = new Label(longString, skin);
        }
        scrollTable = new Table();
        for (int i = 0; i < 100; i++) {
            scrollTable.add(label[i]);
            scrollTable.row();
        }

        scroller = new ScrollPane(scrollTable);

        table = new Table();
        table.setFillParent(true);
        table.add(scroller).fill().expand();

        stage.addActor(table);
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        viewport.apply();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height, true);
        stage.getViewport().update(width, height, true);
        stage.getViewport().apply();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
