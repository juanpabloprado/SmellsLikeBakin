package com.example.smellslikebakin;

public class ListAdapter extends RecyclerAdapter {
    private final ListFragment.OnRecipeSelected listener;

    public ListAdapter(ListFragment.OnRecipeSelected listener) {
        this.listener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        listener.onListRecipeSelected(index);
    }

}
