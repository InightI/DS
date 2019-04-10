#include "SeqList.h"


void Test1() {
#if 1
	SeqList	seqlist;

	SeqListInit(&seqlist, 10);

	SeqListPushBack(&seqlist, 1);
	SeqListPushBack(&seqlist, 2);
	SeqListPushBack(&seqlist, 3);
	SeqListPushBack(&seqlist, 4);
	SeqListPushBack(&seqlist, 5);
	// 1 2 3 4 5

	SeqListPushFront(&seqlist, 10);
	SeqListPushFront(&seqlist, 20);
	SeqListPushFront(&seqlist, 30);
	SeqListPushFront(&seqlist, 40);
	SeqListPushFront(&seqlist, 50);
	// 50 40 30 20 10 1 2 3 4 5
	
	// 再插入应该要扩容
	SeqListInsert(&seqlist, 5, 100);

	SeqListPopFront(&seqlist);
	SeqListPopFront(&seqlist);

	// 30 20 10 100 1 2 3 4 5

	SeqListPopBack(&seqlist);

	// 30 20 10 100 1 2 3 4

	SeqListErase(&seqlist, 3);

	// 30 20 10 1 2 3 4

	SeqListDestroy(&seqlist);
#else
	SeqList *pSeqList = SeqListInit(10);
#endif
}

void Test2() {
	SeqList seqlist;
	SeqListInit(&seqlist, 10);
	SeqListPushBack(&seqlist, 5);
	SeqListPushBack(&seqlist, 2);
	SeqListPushBack(&seqlist, 3);
	SeqListPushBack(&seqlist, 3);
	SeqListPushBack(&seqlist, 4);
	SeqListPushBack(&seqlist, 3);
	SeqListPushBack(&seqlist, 3);
	SeqListRemoveAll(&seqlist, 3);
	SeqListPrint(&seqlist);
}

int main() {
	Test2();
}