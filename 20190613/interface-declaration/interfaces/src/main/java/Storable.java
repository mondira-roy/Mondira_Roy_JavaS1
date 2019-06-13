public interface Storable {
        public void storeData();

        public void retrieveData();

        public default void sillyMethod() {
            //code
        }
    }


}
