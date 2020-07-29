import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowcardrequestComponent } from './showcardrequest.component';

describe('ShowcardrequestComponent', () => {
  let component: ShowcardrequestComponent;
  let fixture: ComponentFixture<ShowcardrequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowcardrequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowcardrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
