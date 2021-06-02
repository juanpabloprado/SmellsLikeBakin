package com.example.smellslikebakin;

public class GridAdapter extends RecyclerAdapter {
    private final GridFragment.OnRecipeSelected listener;

    public GridAdapter(GridFragment.OnRecipeSelected listener) {
        this.listener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        listener.onGridRecipeSelected(index);
    }

}
