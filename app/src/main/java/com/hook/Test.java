package com.hook;


public class Test {

    public void getItem(int position, ViewHolder viewHolder) {

        final int pos = position;
        viewHolder.setOnDataChangeListener(new OnDataChangeListener() {
            @Override
            public void onChange(int index) {
                System.out.print(index + pos);
            }
        });
    }

    public interface OnDataChangeListener {
        void onChange(int index);
    }

    public class ViewHolder {

        private OnDataChangeListener onDataChangeListener;

        public void setOnDataChangeListener(OnDataChangeListener onDataChangeListener) {
            this.onDataChangeListener = onDataChangeListener;
        }
    }

    public OnChangeLister onChangeLister = new OnChangeLister() {
        @Override
        public void onStart() {
            Test.this.onChangeLister = null;
        }

        @Override
        public void onFinish() {

        }
    };


    public interface OnChangeLister {
        void onStart();

        void onFinish();
    }
}
