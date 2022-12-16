//02180201047 Ahmet Zakir Sezginer
package minheap;

import java.util.Arrays;
import java.util.Scanner;

public class MinHeap {
private static int n;

private int sol(int i)
{
return (3* i) + 1;
}
private int orta(int i)
{
return (3 * i) + 2;
}
private int sağ(int i)
{
return (3 * i) + 3;
}


public void sirala(int [] dizi)
{
n = dizi.length-1;

heapify(dizi); 
}

private void heapify(int [] dizi)
{
for(int i = n; i >= 0; i--) heap(dizi,i); 
}

private void heap(int [] dizi, int i)
{
int sol = sol(i);
int sağ= sağ(i);
int orta=orta(i);
int azami = i; 

if((sol <= n) && (dizi[sol] > dizi[azami]) ) 
azami = sol;

if((orta<=n)&&(dizi[orta]>dizi[azami]))
    azami=orta;

if((sağ <= n) && (dizi[sağ] > dizi[azami]) ) 
azami = sağ; 

if(azami != i) 
{
    
int gecici = dizi[i];
dizi[i] = dizi[azami];
dizi[azami] = gecici;

heap(dizi,azami);
}
}

public void yazdir(int [] dizi)
{
for (int i = 0; i < dizi.length; i++) System.out.print(dizi[i] + " ");
}

public static void main(String[] args)
{
MinHeap h = new MinHeap();

Scanner klavye = new Scanner(System.in);
    System.out.println("Kaç eleman girmek istiyorsunuz?");
    int n=klavye.nextInt();
    int dizi[]=new int[n];
    int yedekdizi[] = new int[dizi.length];
    
    System.out.println("Lütfen sayıları giriniz.");
    for(int i=0; i<n;i++){
        dizi[i]=klavye.nextInt();
    }
    for (int i = 0; i < dizi.length; i++){
        yedekdizi[i] = dizi[i];
        
        }
   
    System.out.println("Girilen Dizi");
    h.yazdir(dizi);
    h.sirala(dizi);
    boolean k = Arrays.equals(yedekdizi, dizi);

    if(k == true ){
        System.out.println("\nEvet Min Heaptir");
    }
    else{
        System.out.println("\nDeğildir");
        System.out.println("\nMin Heap hali");
        h.yazdir(dizi);
    }
}
}
