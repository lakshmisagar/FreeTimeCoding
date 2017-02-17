/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */


import java.util.Arrays;
import java.util.Stack;


public class solution {


    public static void main(String args[]){

        StringBuilder result= new StringBuilder();

        Stack<Integer> s=new Stack<Integer>();

        String expression="((AB)CD)E((FG(H)))";

        s.push(0);

        char[] exp= expression.toCharArray();

        for(char c:  exp){

            if(c=='('){

                if (s.peek()==0)

                {    s.pop();

                    s.push(1);

                }

                else

                    result.append(c);

            s.push(0);

            }

            else if(c==')'){

                s.pop();

                if(s.peek()==1){

                    s.pop();

                    s.push(2);

                }

                else

                    result.append(c);

           }

            else{

                if (s.peek()==0){

                    s.pop();

                    s.push(2);

                }

                result.append(c);

            }

        System.out.println(Arrays.toString(s.toArray()));

        }



        System.out.println(result.toString());

        System.out.println("Reversing");

        result=new StringBuilder(expression);

        //result=result.reverse();

        System.out.println(result.toString());

        char[] a=result.toString().toCharArray() ;

        int i=0,j=a.length-1;

        while(i<=j){

            char c=a[i];

            if(a[j]==')')

                a[i]='(';

            else if(a[j]=='(')

                a[i]=')';

            else

                a[i]=a[j];



            if(c==')')

                a[j]='(';

            else if(c=='(')

                a[j]=')';

            else

                a[j]=c;

            i++;

            j--;

        }

        System.out.println("Reversed "+ new String(a));

        //http://stackoverflow.com/questions/40102595/remove-the-parentheses-around-the-very-first-element-in-an-expression-tree-and-i

        String seq="RRSSSRSSSRRRRSSRSRSSSS";

        //char[] c=s.toCharArray();

        Stack<Character> stack= new Stack<Character>();

  /*      for(int v=0;v<seq.length();v++){

            char c=seq.charAt(v);

            for(int z=0;z<seq.length();z++){

            char c=seq.charAt(z);

            if(stack.isEmpty())

            {stack.push(c);

             System.out.print((stack.peek()=='S')?"S":"");

            }



            else if(stack.peek()=='R' && c=='R')

                stack.pop();

            else if(stack.peek()=='S' && c=='R')

                stack.push(c);

            else if(stack.peek()=='R' && c=='S'){

                System.out.print("RS");

                stack.pop();

                stack.push(c);

            }

        }*/

        if(!stack.isEmpty()&& stack.peek()=='R' ){

            System.out.print('R');

        }



        System.out.println();



    }



}
