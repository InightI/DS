#include "SeqList.h"
#include <stdlib.h>
#include <stdio.h>
#include <assert.h>


// O(n)
// static ���κ��������������ԣ����ⲿ�������Ըı�Ϊ�ڲ���������
// ������ݲ���ʱ���Ƿ���Ҫ���ݣ������Ҫ��������
static void CheckCapacity(SeqList *seqlist) {
	if (seqlist->size < seqlist->capacity) {
		return;
	}

	// ��Ҫ���ݵ����
	// �����¿ռ�
	int newCapacity = 2 * seqlist->capacity;
	SLDataType *newArray
		= (SLDataType *)malloc(sizeof(SLDataType)* newCapacity);
	// copy �����ݵ��¿ռ�
	for (int i = 0; i < seqlist->size; i++) {
		newArray[i] = seqlist->array[i];
	}

	// �ͷ��Ͽռ䣬���¿ռ�󶨵�˳���ṹ��
	free(seqlist->array);
	seqlist->array = newArray;

	// ��������
	seqlist->capacity = newCapacity;
}

void SeqListInit(SeqList *seqlist, int capacity) {
	// �ڶ��Ϸ���˳���Ĵ洢�ռ�
	// ��ʼ��������size �ֶ�

	assert(seqlist != NULL);

	seqlist->array
		= (SLDataType *)malloc(sizeof(SLDataType)* capacity);
	seqlist->capacity = capacity;
	seqlist->size = 0;
}

void SeqListDestroy(SeqList *seqlist) {
	// �ͷ�˳���Ĵ洢�ռ�
	// ����Ĺ��������ֶ� reset Ϊ��ʼֵ
	assert(seqlist != NULL);
	assert(seqlist->array != NULL);

	free(seqlist->array);

	// ������
	seqlist->array = NULL;
	seqlist->capacity = seqlist->size = 0;
}

// ʱ�临�Ӷ� O(1)
void SeqListPushBack(SeqList *seqlist, SLDataType v) {
	CheckCapacity(seqlist);
	seqlist->array[seqlist->size] = v;
	seqlist->size++;
}

// O(n)
void SeqListPushFront(SeqList *seqlist, SLDataType v) {
	CheckCapacity(seqlist);
	// ���ݵ��ƶ�����
	for (int i = seqlist->size; i >= 1; i--) { // i �ռ�
		seqlist->array[i] = seqlist->array[i - 1];
	}

#if 0
	for (int i = seqlist->size - 1; i >= 0; i--) { // i ����
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