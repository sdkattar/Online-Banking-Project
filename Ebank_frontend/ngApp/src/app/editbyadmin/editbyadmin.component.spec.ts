import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditbyadminComponent } from './editbyadmin.component';

describe('EditbyadminComponent', () => {
  let component: EditbyadminComponent;
  let fixture: ComponentFixture<EditbyadminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditbyadminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditbyadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
