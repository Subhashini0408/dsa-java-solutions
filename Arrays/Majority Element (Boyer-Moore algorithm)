/*
Problem: Majority Element

Approach:
Use Boyer-Moore Voting Algorithm to find the majority element.

1. Maintain a candidate element and a count.
2. If count becomes zero, choose the current element as the new candidate.
3. Increment count if the current element matches the candidate,
   otherwise decrement it.
4. The remaining candidate after traversal will be the majority element.

Time Complexity: O(n)
Space Complexity: O(1)
*/
int candidate = 0;
     int count = 0;
     for(int num : nums)
     {
        if(count == 0)
        {
            candidate = num;
        }
        if(num == candidate)
        {
            count++;
        }
        else
        {
            count--;
        }
     }
     return candidate;
    }
}
