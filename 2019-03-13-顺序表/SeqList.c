#include "SeqList.h"
#include <stdlib.h>
#include <stdio.h>
#include <assert.h>


// O(n)
// static 修饰函数更改链接属性，从外部链接属性改变为内部链接属性
// 检查数据插入时，是否需要扩容，如果需要，则扩容
static void CheckCapacity(SeqList *seqlist) {
	if (seqlist->size < seqlist->capacity) {
		return;
	}

	// 需要扩容的情况
	// 申请新空间
	int newCapacity = 2 * seqlist->capacity;
	SLDataType *newArray
		= (SLDataType *)malloc(sizeof(SLDataType)* newCapacity);
	// copy 老数据到新空间
	for (int i = 0; i < seqlist->size; i++) {
		newArray[i] = seqlist->array[i];
	}

	// 释放老空间，把新空间绑定到顺序表结构体
	free(seqlist->array);
	seqlist->array = newArray;

	// 更新容量
	seqlist->capacity = newCapacity;
}

void SeqListInit(SeqList *seqlist, int capacity) {
	// 在堆上分配顺序表的存储空间
	// 初始化容量、size 字段

	assert(seqlist != NULL);

	seqlist->array
		= (SLDataType *)malloc(sizeof(SLDataType)* capacity);
	seqlist->capacity = capacity;
	seqlist->size = 0;
}

void SeqListDestroy(SeqList *seqlist) {
	// 释放顺序表的存储空间
	// 额外的工作，把字段 reset 为初始值
	assert(seqlist != NULL);
	assert(seqlist->array != NULL);

	free(seqlist->array);

	// 锦上添花
	seqlist->array = NULL;
	seqlist->capacity = seqlist->size = 0;
}

// 时间复杂度 O(1)
void SeqListPushBack(SeqList *seqlist, SLDataType v) {
	CheckCapacity(seqlist);
	seqlist->array[seqlist->size] = v;
	seqlist->size++;
}

// O(n)
void SeqListPushFront(SeqList *seqlist, SLDataType v) {
	CheckCapacity(seqlist);
	// 数据的移动过程
	for (int i = seqlist->size; i >= 1; i--) { // i 空间
		seqlist->array[i] = seqlist->array[i - 1];
	}

#if 0
	for (int i = seqlist->size - 1; i >= 0; i--) { // i 数据
		seqlist->array[i + 1] = seqlist->array[i];
	}
#endif

	seqlist->array[0] = v;
	seqlist->size++;
}

// O(n)
void SeqListInsert(SeqList *seqlist, int pos, SLDataType v) {
	assert(pos >= 0 && pos <= seqlist->size);
	CheckCapacity(seqlist);
	for (int i = seqlist->size; i > pos; i--) {
		seqlist->array[i] = seqlist->array[i - 1];
	}

	seqlist->array[pos] = v;
	seqlist->size++;
}

// O(1)
void SeqListPopBack(SeqList *seqlist) {
	assert(seqlist != NULL);
	assert(seqlist->size > 0);
	seqlist->size--;
}


void SeqListPopFront(SeqList *seqlist) {
	assert(seqlist != NULL);
	assert(seqlist->size > 0);

	for (int i = 0; i < seqlist->size - 1; i++) {
		seqlist->array[i] = seqlist->array[i + 1];
	}

	seqlist->size--;
}

// O(n)
void SeqListErase(SeqList *seqlist, int pos) {
	assert(seqlist != NULL);
	assert(seqlist->size > 0);
	assert(pos >= 0 && pos <= seqlist->size - 1);

	for (int i = pos; i <= seqlist->size - 2; i++) {
		seqlist->array[i] = seqlist->array[i + 1];
	}

	seqlist->size--;
}

// O(n)
void SeqListRemove(SeqList *seqlist, SLDataType v) {
	int pos = SeqListFind(seqlist, v);
	if (pos == -1) {
		return;
	}
	SeqListErase(seqlist, pos);
}


void SeqListRemoveAll(SeqList *seqlist, SLDataType v) {
	int i, j;
	for (i = 0, j = 0; i < seqlist->size; i++) {
		if (seqlist->array[i] != v) {
			seqlist->array[j] = seqlist->array[i];
			j++;
		}
	}

	seqlist->size = j;
}