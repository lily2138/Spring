package exception.runtime.test;
/*
 * NullPointerException::
 * ��ü �������� �ʰ� ��ü�� ����� �����Ϸ��� �� �� �߻��ϴ� ����....
 * ��ü �������� �ʰ� == null
 * 
 * catch�� ������ �� �� �ִ�...
 * ������ �� �߿��� �� �ѹ��� ����ȴ�....
 * 
 * finally
 * ::
 * ���ܿ� ������� ������ ����Ǿ����� �ϴ� �ڵ尡 �ִٸ�...
 * �� �ȿ��� ����־�� �Ѵ�.
 */
public class RuntimeExceptionTest3 {

	public static void main(String[] args) {
		System.out.println("==========NullPointerException=========");
		String str = new String("Encore"); //Heap
		str=null; 
		try {
			System.out.println("str�� ������ �� ::"+str);
			System.out.println("str ���ڿ� ���� ::" +str.length());
		}catch(Exception e ) {
			System.out.println("��Ҵ�...Exception");
		}/*catch(NullPointerException e ) { 				//�̷��Դ� ����´�. �����ٲ���� 
			System.out.println("��Ҵ�...NullPointerException");
		}*/finally {
			System.out.println("Always Print...");
		}
	}

}
/*
1. ���� �߻��ڵ� �ۼ�... + ���ܰ� �߻� ����.
	try + finally
2. ���� �߻��ڵ� �ۼ�... + ���� �߻� + �� ���ܸ� �� ����
	catch + finally
3. ���� �߻��ڵ� �ۼ�... + ���� �߻� + �� ���ܸ� �� �� ����
	finally
	
	finally�� �ַ� �ִ� �ڵ�
	--->�ڿ��� �ݳ��ϴ� �ڵ�....close()

	finally�� �������� �ʴ� ��찡 �ִ�.
	1) finally �ȿ��� �Ǵٸ� ���ܰ� �߻��� ���� ������ �ȵȴ� ---> �׷� �� �� ���� try catch�� ���ξ��Ѵ�.
	
	
	
 */