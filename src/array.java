//demonstrate Java arrays
//


import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

class ArrayApp{
    public static void main(String[] args){
        long[] arr;
        arr = new long[100];
        int nElems = 0;
        int j;
        long searchKey;
        //..................................................
        arr[0] = 77;//insert 10 items
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 00;
        arr[8] = 66;
        arr[9] = 33;
        nElems = 10;//now 10 items
        //..................................................
        searchKey = 66;//find items with key 66
        for(j=0;j<nElems;j++)//for each element,
            if(arr[j]==searchKey)//found item?
                break;//yes, exit before end
        if(j == nElems)//at the end?
            System.out.println("Cannot find "+searchKey);//yes
        else
            System.out.println("Found "+searchKey);//no

        //..................................................

        searchKey =55;//delete item with key 55
        for(j=0;j<nElems;j++)//look for it
            if(arr[j]==searchKey)
                break;
        for(int k=j;k<nElems;k++)
            arr[k] = arr[k+1];
        nElems--;
        //
        for(j=0;j<nElems;j++)//display items
            System.out.println(arr[j]+" ");
        System.out.println(" ");



    }//end main()
}//end class ArrayApp
