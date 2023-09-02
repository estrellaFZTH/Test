public class ll {
    // ����
    // 1,2,3,4,5,6,7
    // 3,4,5,6,7,1,2,2
    // 10111
    // 01234
    //10111 �� 11101 ���֡���������� nums[start] == nums[mid]��
    // �ֲ��嵽����ǰ�������Ǻ������򣬴�ʱ start++ ���ɡ��൱��ȥ��һ���ظ��ĸ����

    //���������ظ�Ԫ�ص���������ʱ�����ǻ�����һ�����⣺��� nums[left] nums[mid] nums[right]
    // ʱ��ô�죿���� [2,1,2,2,2] �� [2,2,2,1,2]���ʼʱ��left ָ�� �� 0 λ�ã�right
    // ָ��� 4 λ�ã�mid ָ���м�� 2 λ�ã���ʱ������ȶ�Ϊ 2������������� 1������� 1 ��
    // ���� mid �����Ҳ������ mid ���ұߡ�
    // ���ԾͲ�֪�������ĸ��������������
    //һ���������İ취�ǣ��������� nums[left] == nums[right] �����ʱ��ֱ�������ƶ� left��
    // ֱ�� nums[left] != nums[right]���������Ļ�������������оͱ������ [1,2,2,2]��
    // [2,2,2,1]
    // ��������1 ���ڵ�����Ϳ��Ը��� mid �� right �Ĵ�С��ϵ������ˡ�
    //�������£���������Ĵ���Ļ����������� nums[left] �� nums[right]��ȵ�ʱ����жϴ��롣

    // �����±� int���庯��
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[left] == nums[mid]){
                left++;
                continue;
            }
            if(nums[mid] >= nums[left]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[right] >= target && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
